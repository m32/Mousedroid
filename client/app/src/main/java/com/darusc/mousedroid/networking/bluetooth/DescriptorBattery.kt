package com.darusc.mousedroid.networking.bluetooth

val HID_REPORT_BATTERY_DESC = byteArrayOf(
    // Battery report
    0x05.toByte(), 0x0C.toByte(),             // USAGE_PAGE (Consumer Devices)
    0x09.toByte(), 0x01.toByte(),             // USAGE (Consumer Control)
    0xA1.toByte(), 0x01.toByte(),             // COLLECTION (Application)
    0x85.toByte(), REPORT_ID_BATTERY.toByte(),
    0x05.toByte(), 0x06.toByte(),             //   USAGE_PAGE (Generic Device Controls) <-- FIXED (0x06)
    0x09.toByte(), 0x20.toByte(),             //   USAGE (Battery Strength)             <-- FIXED (0x20)
    0x15.toByte(), 0x00.toByte(),             //   LOGICAL_MINIMUM (0)
    0x25.toByte(), 0x64.toByte(),             //   LOGICAL_MAXIMUM (100)
    0x75.toByte(), 0x08.toByte(),             //   REPORT_SIZE (8)
    0x95.toByte(), 0x01.toByte(),             //   REPORT_COUNT (1)
    0x81.toByte(), 0x02.toByte(),             //   INPUT (Data,Var,Abs)
    0xC0.toByte(),                            // END_COLLECTION
)
