package com.darusc.mousedroid.networking.bluetooth

fun INPUT(size: Int): Byte = (size or 0x80).toByte()
fun OUTPUT(size: Int): Byte = (size or 0x90).toByte()
fun COLLECTION(size: Int): Byte = (size or 0xa0).toByte()
fun FEATURE(size: Int): Byte = (size or 0xb0).toByte()
fun END_COLLECTION(size: Int): Byte = (size or 0xc0).toByte()

fun USAGE_PAGE(size: Int): Byte = (size or 0x04).toByte()
fun LOGICAL_MINIMUM(size: Int): Byte = (size or 0x14).toByte()
fun LOGICAL_MAXIMUM(size: Int): Byte = (size or 0x24).toByte()
fun PHYSICAL_MINIMUM(size: Int): Byte = (size or 0x34).toByte()
fun PHYSICAL_MAXIMUM(size: Int): Byte = (size or 0x44).toByte()
fun UNIT_EXPONENT(size: Int): Byte = (size or 0x54).toByte()
fun UNIT(size: Int): Byte = (size or 0x64).toByte()
fun REPORT_SIZE(size: Int): Byte = (size or 0x74).toByte()  //bits
fun REPORT_ID(size: Int): Byte = (size or 0x84).toByte()
fun REPORT_COUNT(size: Int): Byte = (size or 0x94).toByte()  //bytes
fun PUSH(size: Int): Byte = (size or 0xa4).toByte()
fun POP(size: Int): Byte = (size or 0xb4).toByte()
fun HIDINPUT(size: Int): Byte =(0x80 or size).toByte()
fun HIDOUTPUT(size: Int): Byte = (0x90 or size).toByte()

/* Local items */
fun USAGE(size: Int): Byte = (size or 0x08).toByte()
fun USAGE_MINIMUM(size: Int): Byte = (size or 0x18).toByte()
fun USAGE_MAXIMUM(size: Int): Byte = (size or 0x28).toByte()
fun DESIGNATOR_INDEX(size: Int): Byte = (size or 0x38).toByte()
fun DESIGNATOR_MINIMUM(size: Int): Byte = (size or 0x48).toByte()
fun DESIGNATOR_MAXIMUM(size: Int): Byte = (size or 0x58).toByte()
fun STRING_INDEX(size: Int): Byte = (size or 0x78).toByte()
fun STRING_MINIMUM(size: Int): Byte = (size or 0x88).toByte()
fun STRING_MAXIMUM(size: Int): Byte = (size or 0x98).toByte()
fun DELIMITER(size: Int): Byte = (size or 0xa8).toByte()

const val REPORT_ID_KEYBOARD = 0x01
const val REPORT_ID_MOUSE = 0x02
const val REPORT_ID_MEDIA = 0x03
const val REPORT_ID_BATTERY = 0x04
const val REPORT_ID_GAMEPAD = 0x05

/**
 * https://www.usb.org/sites/default/files/documents/hut1_12v2.pdf
 */
