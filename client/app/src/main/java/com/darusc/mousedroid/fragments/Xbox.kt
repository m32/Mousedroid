package com.darusc.mousedroid.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.darusc.mousedroid.R
import com.darusc.mousedroid.databinding.FragmentXboxBinding
import com.darusc.mousedroid.mkinput.InputEvent
import com.darusc.mousedroid.networking.ConnectionManager
import com.darusc.mousedroid.viewmodels.XboxViewModel
import java.util.Timer
import kotlin.concurrent.timer

import kotlin.math.cos
import kotlin.math.sin
import com.darusc.mousedroid.sensor.Constants as SensorConstants


class Xbox : Fragment() {
    private val tag = "Mousedroid.XBOX"
    private lateinit var binding: FragmentXboxBinding

    private val viewModel: XboxViewModel by activityViewModels()
    private val connectionManager = ConnectionManager.getInstance()
    private lateinit var timer : Timer

    private var xbutton : Int = 0
    private var xlx : Int = 0
    private var xly : Int = 0
    private var xrx : Int = 0
    private var xry : Int = 0
    private var send: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_xbox, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        timer = timer("timer", false, period = SensorConstants.loopRate.toLong(), initialDelay = 0L){
            if( send ) {
                Log.d(tag, "timer: $xbutton $xlx $xly $xrx $xry")
                connectionManager.send(InputEvent.XboxEvent(xbutton, xlx, xly, xrx, xry))
                send = false
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer.cancel()
    }

    private fun setListener(button: View, bit: Int){
        button.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    xbutton = xbutton or (1 shl bit)
                    send = true
                    true // Return true to continue tracking the gesture
                }
                MotionEvent.ACTION_UP -> {
                    // Finger released
                    v.performClick()
                    xbutton = xbutton and (1 shl bit).inv()
                    send = true
                    // Execute release code here
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    // Handle aborted gesture
                    true
                }
                else -> false
            }
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener(binding.buttonA, SensorConstants.BUTTON_A_BIT)
        setListener(binding.buttonB, SensorConstants.BUTTON_B_BIT)
        setListener(binding.buttonX, SensorConstants.BUTTON_X_BIT)
        setListener(binding.buttonY, SensorConstants.BUTTON_Y_BIT)

        setListener(binding.buttonRT, SensorConstants.BUTTON_RT_BIT)
        setListener(binding.buttonLT, SensorConstants.BUTTON_LT_BIT)
        setListener(binding.buttonRB, SensorConstants.BUTTON_RB_BIT)
        setListener(binding.buttonLB, SensorConstants.BUTTON_LB_BIT)

        setListener(binding.buttonBack, SensorConstants.BUTTON_BACK_BIT)
        setListener(binding.buttonStart, SensorConstants.BUTTON_START_BIT)

        setListener(binding.buttonUp, SensorConstants.BUTTON_UP_BIT)
        setListener(binding.buttonDown, SensorConstants.BUTTON_DOWN_BIT)
        setListener(binding.buttonLeft, SensorConstants.BUTTON_LEFT_BIT)
        setListener(binding.buttonRight, SensorConstants.BUTTON_RIGHT_BIT)

        binding.leftJoystickView.setOnMoveListener({ angle, strength ->
            // -127 <= x <= 127
            xlx = (strength * cos(angle) * 127).toInt()
            xly = (strength * sin(angle) * 127).toInt()
            send = true
        }, SensorConstants.loopRate)

        binding.rightJoystickView.setOnMoveListener({ angle, strength ->
            // 0 <= x <= 1023
            xrx = (511 + strength * cos(angle) * 512).toInt()
            xry = (511 + strength * sin(angle) * 512).toInt()
            send = true
        }, SensorConstants.loopRate)

    }
}
