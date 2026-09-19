package com.darusc.mousedroid.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.darusc.mousedroid.JoystickView.OnMoveListener
import com.darusc.mousedroid.R
import com.darusc.mousedroid.databinding.FragmentXboxBinding
import com.darusc.mousedroid.layouts.Keycode
import com.darusc.mousedroid.mkinput.InputEvent
import com.darusc.mousedroid.networking.ConnectionManager
import com.darusc.mousedroid.viewmodels.XboxViewModel
import java.util.Timer
import kotlin.concurrent.timer

import kotlin.math.cos
import kotlin.math.sin
import com.darusc.mousedroid.sensor.Constants as SensorConstants


class Xbox : Fragment() {
    private val TAG = "Mousedroid.XBOX"
    private lateinit var binding: FragmentXboxBinding

    private val viewModel: XboxViewModel by activityViewModels()
    private val connectionManager = ConnectionManager.getInstance()
    private lateinit var mytimer : Timer

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
        mytimer = timer("timer", false, period = SensorConstants.loopRate.toLong(), initialDelay = 0L){
            if (send || xbutton != 0 || xlx != 0 || xly != 0 || xrx != 0 || xry != 0) {
                send = !(xbutton == 0 && xlx == 0 && xly == 0 && xrx == 0 && xry == 0)
                Log.d(TAG, "timer: " + xbutton + " " + xlx + " " + xly + " " + xrx + " " + xry)
                connectionManager.send(InputEvent.XboxEvent(xbutton, xlx, xly, xrx, xry));
                xbutton = 0
                xlx = 0
                xly = 0
                xrx = 0
                xry = 0
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mytimer.cancel();
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonA.setOnClickListener { xbutton = xbutton or (1 shl SensorConstants.BUTTON_A_BIT) }
        binding.buttonB.setOnClickListener { xbutton = xbutton or (1 shl SensorConstants.BUTTON_B_BIT) }
        binding.buttonX.setOnClickListener { xbutton = xbutton or (1 shl SensorConstants.BUTTON_X_BIT) }
        binding.buttonY.setOnClickListener { xbutton = xbutton or (1 shl SensorConstants.BUTTON_Y_BIT) }
        binding.buttonRT.setOnClickListener { xbutton = xbutton or (1 shl SensorConstants.BUTTON_RT_BIT) }
        binding.buttonLT.setOnClickListener { xbutton = xbutton or (1 shl SensorConstants.BUTTON_LT_BIT) }
        binding.buttonRB.setOnClickListener { xbutton = xbutton or (1 shl SensorConstants.BUTTON_RB_BIT) }
        binding.buttonLB.setOnClickListener { xbutton = xbutton or (1 shl SensorConstants.BUTTON_LB_BIT) }
        binding.buttonBack.setOnClickListener { xbutton = xbutton or (1 shl SensorConstants.BUTTON_BACK_BIT) }
        binding.buttonStart.setOnClickListener { xbutton = xbutton or (1 shl SensorConstants.BUTTON_START_BIT) }
        binding.buttonUp.setOnClickListener { xbutton = xbutton or (1 shl SensorConstants.BUTTON_UP_BIT) }
        binding.buttonDown.setOnClickListener { xbutton = xbutton or (1 shl SensorConstants.BUTTON_DOWN_BIT) }
        binding.buttonLeft.setOnClickListener { xbutton = xbutton or (1 shl SensorConstants.BUTTON_LEFT_BIT) }
        binding.buttonRight.setOnClickListener { xbutton = xbutton or (1 shl SensorConstants.BUTTON_RIGHT_BIT) }

        binding.leftJoystickView.setOnMoveListener(object : OnMoveListener {
            override fun onMove(angle: Double, strength: Double) {
                xlx = (strength * cos(angle) * SensorConstants.JOYSTICK_RANGE_NUM).toInt()
                xly = (-1 * strength * sin(angle) * SensorConstants.JOYSTICK_RANGE_NUM).toInt()
            }
        }, SensorConstants.loopRate)

        binding.rightJoystickView.setOnMoveListener(object : OnMoveListener {
            override fun onMove(angle: Double, strength: Double) {
                xrx = (strength * cos(angle) * SensorConstants.JOYSTICK_RANGE_NUM).toInt()
                xry = (-1 * strength * sin(angle) * SensorConstants.JOYSTICK_RANGE_NUM).toInt()
            }
        }, SensorConstants.loopRate)

    }
}
