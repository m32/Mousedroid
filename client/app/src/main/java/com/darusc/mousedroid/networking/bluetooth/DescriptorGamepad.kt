package com.darusc.mousedroid.networking.bluetooth

val HID_REPORT_GAMEPAD_DESC = byteArrayOf(
    0x05.toByte(), 0x01.toByte(),        // USAGE_PAGE (Generic Desktop)
    0x09.toByte(), 0x05.toByte(),        // USAGE (Game Pad)
    0xA1.toByte(), 0x01.toByte(),        // COLLECTION (Application)
    0x85.toByte(), REPORT_ID_GAMEPAD.toByte(),
    // --- PRZYCISKI (2 bajty = 16 bitów) ---
    0x05.toByte(), 0x09.toByte(),        //   USAGE_PAGE (Button)
    0x19.toByte(), 0x01.toByte(),        //   USAGE_MINIMUM (Button 1)
    0x29.toByte(), 0x10.toByte(),        //   USAGE_MAXIMUM (Button 16)
    0x15.toByte(), 0x00.toByte(),        //   LOGICAL_MINIMUM (0) - Puszczony
    0x25.toByte(), 0x01.toByte(),        //   LOGICAL_MAXIMUM (1) - Wciśnięty
    0x75.toByte(), 0x01.toByte(),        //   REPORT_SIZE (1 bit na przycisk)
    0x95.toByte(), 0x10.toByte(),        //   REPORT_COUNT (16 przycisków)
    0x81.toByte(), 0x02.toByte(),        //   INPUT (Data, Var, Abs)
    0x05.toByte(), 0x01.toByte(),        //   USAGE_PAGE (Generic Desktop)
    // --- DŻOJSTIK (2 bajty) ---
    0x09.toByte(), 0x30.toByte(),        //   USAGE (X) - Lewy dżojstik poziom
    0x09.toByte(), 0x31.toByte(),        //   USAGE (Y) - Lewy dżojstik pion
    0x09.toByte(), 0x32.toByte(),        //   USAGE (Z) - Prawy dżojstik poziom
    0x09.toByte(), 0x35.toByte(),        //   USAGE (Rz) - Prawy dżojstik pion
    0x15.toByte(), 0x81.toByte(),        //   LOGICAL_MINIMUM (-127)
    0x25.toByte(), 0x7F.toByte(),        //   LOGICAL_MAXIMUM (127)
    0x75.toByte(), 0x08.toByte(),        //   REPORT_SIZE (8 bitów na jedną oś)
    0x95.toByte(), 0x02.toByte(),        //   REPORT_COUNT (4 osie)
    0x81.toByte(), 0x02.toByte(),        //   INPUT (Data, Var, Abs) -> Zmienna bezwzględna
    // --- D-PAD / HAT SWITCH (1 bajt) ---
    0x09.toByte(), 0x39.toByte(),        //   USAGE (Hat switch)
    0x15.toByte(), 0x00.toByte(),        //   LOGICAL_MINIMUM (0) - Środek / brak wciśnięcia
    0x25.toByte(), 0x07.toByte(),        //   LOGICAL_MAXIMUM (7) - 8 kierunków (0=Północ, 1=Pn-Ws, itd.)
    0x35.toByte(), 0x00.toByte(),        //   PHYSICAL_MINIMUM (0)
    0x45.toByte(), 0x3B.toByte(),        //   PHYSICAL_MAXIMUM (315) - Kąt w stopniach (7 * 45° = 315°)
    0x75.toByte(), 0x04.toByte(),        //   REPORT_SIZE (4 bity na D-pad)
    0x95.toByte(), 0x01.toByte(),        //   REPORT_COUNT (1 D-pad)
    0x81.toByte(), 0x02.toByte(),        //   INPUT (Data, Var, Abs)
    // Dopełnienie (Padding) - D-pad zajmuje 4 bity.toByte(), musimy dobić do pełnego bajtu (8 bitów)
    0x75.toByte(), 0x04.toByte(),        //   REPORT_SIZE (4 bity)
    0x95.toByte(), 0x01.toByte(),        //   REPORT_COUNT (1)
    0x81.toByte(), 0x03.toByte(),        //   INPUT (Cnst, Var, Abs) -> Stała (ignorowana przez system)
    0xC0.toByte()               // END_COLLECTION
);
