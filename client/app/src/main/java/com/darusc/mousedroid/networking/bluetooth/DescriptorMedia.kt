package com.darusc.mousedroid.networking.bluetooth

val HID_REPORT_MEDIA_DESC = byteArrayOf(
    0x05.toByte(), 0x0C.toByte(),        // USAGE_PAGE (Consumer Devices)
    0x09.toByte(), 0x01.toByte(),        // USAGE (Consumer Control)
    0xA1.toByte(), 0x01.toByte(),        // COLLECTION (Application)
    0x85.toByte(), REPORT_ID_MEDIA.toByte(),
    //---------------------------------------------------------
    // Definicja 6 klawiszy multimedialnych (każdy zajmuje 1 bit)
    //---------------------------------------------------------
    0x15.toByte(), 0x00.toByte(),        //   LOGICAL_MINIMUM (0) - przycisk puszczony
    0x25.toByte(), 0x01.toByte(),        //   LOGICAL_MAXIMUM (1) - przycisk wciśnięty
    0x75.toByte(), 0x01.toByte(),        //   REPORT_SIZE (1)     - każdy element ma 1 bit
    0x95.toByte(), 0x0a.toByte(),        //   REPORT_COUNT (8)   - mamy 8 takich elementów (bitów)
    0x09.toByte(), 0xB3.toByte(),        //   USAGE (Fast Forward)
    0x09.toByte(), 0xB4.toByte(),        //   USAGE (Rewind)
    0x09.toByte(), 0xB5.toByte(),        //   USAGE (Scan Next Track)
    0x09.toByte(), 0xB6.toByte(),        //   USAGE (Scan Previous Track)
    0x09.toByte(), 0xCD.toByte(),        //   USAGE (Play/Pause)
    0x09.toByte(), 0xE2.toByte(),        //   USAGE (Mute)
    0x09.toByte(), 0xE9.toByte(),        //   USAGE (Volume Increment)
    0x09.toByte(), 0xEA.toByte(),        //   USAGE (Volume Decrement)
    0x81.toByte(), 0x02.toByte(),        //   INPUT (Data,Var,Abs)        - Przesyłaj jako zmienne zmienne (0 lub 1)
    //---------------------------------------------------------
    // Dopełnienie do pełnego bajtu nie występuje
    //---------------------------------------------------------
    //0x75.toByte(), 0x06.toByte(),        //   REPORT_SIZE (6 bity)
    //0x95.toByte(), 0x01.toByte(),        //   REPORT_COUNT (1)
    //0x81.toByte(), 0x03.toByte(),        //   INPUT (Cnst,Var,Abs)        - Stała (zignoruj te bity)
    //---------------------------------------------------------
    0xC0.toByte()               // END_COLLECTION
)
