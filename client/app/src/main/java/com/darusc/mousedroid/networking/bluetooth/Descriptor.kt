package com.darusc.mousedroid.networking.bluetooth

const val REPORT_ID_KEYBOARD = 0x01
const val REPORT_ID_MOUSE = 0x02
const val REPORT_ID_MEDIA = 0x03
const val REPORT_ID_BATTERY = 0x04

private fun INPUT(size: Int): Byte = (size or 0x80).toByte()
private fun OUTPUT(size: Int): Byte = (size or 0x90).toByte()
private fun COLLECTION(size: Int): Byte = (size or 0xa0).toByte()
private fun FEATURE(size: Int): Byte = (size or 0xb0).toByte()
private fun END_COLLECTION(size: Int): Byte = (size or 0xc0).toByte()

private fun USAGE_PAGE(size: Int): Byte = (size or 0x04).toByte()
private fun LOGICAL_MINIMUM(size: Int): Byte = (size or 0x14).toByte()
private fun LOGICAL_MAXIMUM(size: Int): Byte = (size or 0x24).toByte()
private fun PHYSICAL_MINIMUM(size: Int): Byte = (size or 0x34).toByte()
private fun PHYSICAL_MAXIMUM(size: Int): Byte = (size or 0x44).toByte()
private fun UNIT_EXPONENT(size: Int): Byte = (size or 0x54).toByte()
private fun UNIT(size: Int): Byte = (size or 0x64).toByte()
private fun REPORT_SIZE(size: Int): Byte = (size or 0x74).toByte()  //bits
private fun REPORT_ID(size: Int): Byte = (size or 0x84).toByte()
private fun REPORT_COUNT(size: Int): Byte = (size or 0x94).toByte()  //bytes
private fun PUSH(size: Int): Byte = (size or 0xa4).toByte()
private fun POP(size: Int): Byte = (size or 0xb4).toByte()

/* Local items */
private fun USAGE(size: Int): Byte = (size or 0x08).toByte()
private fun USAGE_MINIMUM(size: Int): Byte = (size or 0x18).toByte()
private fun USAGE_MAXIMUM(size: Int): Byte = (size or 0x28).toByte()
private fun DESIGNATOR_INDEX(size: Int): Byte = (size or 0x38).toByte()
private fun DESIGNATOR_MINIMUM(size: Int): Byte = (size or 0x48).toByte()
private fun DESIGNATOR_MAXIMUM(size: Int): Byte = (size or 0x58).toByte()
private fun STRING_INDEX(size: Int): Byte = (size or 0x78).toByte()
private fun STRING_MINIMUM(size: Int): Byte = (size or 0x88).toByte()
private fun STRING_MAXIMUM(size: Int): Byte = (size or 0x98).toByte()
private fun DELIMITER(size: Int): Byte = (size or 0xa8).toByte()

/**
 * https://www.usb.org/sites/default/files/documents/hut1_12v2.pdf
 */
val HID_REPORT_DESC = byteArrayOf(
    // KEYBOARD
    0x05.toByte(), 0x01.toByte(),  // Usage Page (Generic Desktop Ctrls)
    0x09.toByte(), 0x06.toByte(),  // Usage (Keyboard)
    0xA1.toByte(), 0x01.toByte(),  // Collection (Application)
    0x85.toByte(), REPORT_ID_KEYBOARD.toByte(),  //   Report ID (1)
    0x05.toByte(), 0x07.toByte(),  //   Usage Page (Kbrd/Keypad)
    0x19.toByte(), 0xE0.toByte(),  //   Usage Minimum (0xE0 - Left Control)
    0x29.toByte(), 0xE7.toByte(),  //   Usage Maximum (0xE7 - Right GUI)
    0x15.toByte(), 0x00.toByte(),  //   Logical Minimum (0)
    0x25.toByte(), 0x01.toByte(),  //   Logical Maximum (1)
    0x75.toByte(), 0x01.toByte(),  //   Report Size (1)
    0x95.toByte(), 0x08.toByte(),  //   Report Count (8)
    0x81.toByte(), 0x02.toByte(),  //   Input (Data,Var,Abs,No Wrap,Linear,Preferred State,No Null Position)
    0x95.toByte(), 0x01.toByte(),  //   Report Count (1)
    0x75.toByte(), 0x08.toByte(),  //   Report Size (8)
    0x81.toByte(), 0x03.toByte(),  //   Input (Const,Var,Abs) - Padding
    0x95.toByte(), 0x05.toByte(),  //   Report Count (5)
    0x75.toByte(), 0x01.toByte(),  //   Report Size (1)
    0x05.toByte(), 0x08.toByte(),  //   Usage Page (LEDs)
    0x19.toByte(), 0x01.toByte(),  //   Usage Minimum (Num Lock)
    0x29.toByte(), 0x05.toByte(),  //   Usage Maximum (Kana)
    0x91.toByte(), 0x02.toByte(),  //   Output (Data,Var,Abs,No Wrap,Linear,Preferred State,No Null Position,Non-volatile)
    0x95.toByte(), 0x01.toByte(),  //   Report Count (1)
    0x75.toByte(), 0x03.toByte(),  //   Report Size (3)
    0x91.toByte(), 0x03.toByte(),  //   Output (Const,Var,Abs,No Wrap,Linear,Preferred State,No Null Position,Non-volatile) - Padding
    0x95.toByte(), 0x06.toByte(),  //   Report Count (6)
    0x75.toByte(), 0x08.toByte(),  //   Report Size (8)
    0x15.toByte(), 0x00.toByte(),  //   Logical Minimum (0)
    0x25.toByte(), 0x65.toByte(),  //   Logical Maximum (101)
    0x05.toByte(), 0x07.toByte(),  //   Usage Page (Kbrd/Keypad)
    0x19.toByte(), 0x00.toByte(),  //   Usage Minimum (0x00)
    0x29.toByte(), 0x65.toByte(),  //   Usage Maximum (0x65)
    0x81.toByte(), 0x00.toByte(),  //   Input (Data,Array,Abs,No Wrap,Linear,Preferred State,No Null Position)
    0xC0.toByte(),  // End Collection

    // MOUSE
    0x05.toByte(), 0x01.toByte(),  // Usage Page (Generic Desktop Ctrls)
    0x09.toByte(), 0x02.toByte(),  // Usage (Mouse)
    0xA1.toByte(), 0x01.toByte(),  // Collection (Application)
    0x85.toByte(), REPORT_ID_MOUSE.toByte(),  //   Report ID (2)
    0x09.toByte(), 0x01.toByte(),  //   Usage (Pointer)
    0xA1.toByte(), 0x00.toByte(),  //   Collection (Physical)
    0x05.toByte(), 0x09.toByte(),  //     Usage Page (Button)
    0x19.toByte(), 0x01.toByte(),  //     Usage Minimum (0x01)
    0x29.toByte(), 0x03.toByte(),  //     Usage Maximum (0x03)
    0x15.toByte(), 0x00.toByte(),  //     Logical Minimum (0)
    0x25.toByte(), 0x01.toByte(),  //     Logical Maximum (1)
    0x95.toByte(), 0x03.toByte(),  //     Report Count (3)
    0x75.toByte(), 0x01.toByte(),  //     Report Size (1)
    0x81.toByte(), 0x02.toByte(),  //     Input (Data,Var,Abs)
    0x95.toByte(), 0x01.toByte(),  //     Report Count (1)
    0x75.toByte(), 0x05.toByte(),  //     Report Size (5)
    0x81.toByte(), 0x03.toByte(),  //     Input (Const,Var,Abs)
    0x05.toByte(), 0x01.toByte(),  //     Usage Page (Generic Desktop Ctrls)
    0x09.toByte(), 0x30.toByte(),  //     Usage (X)
    0x09.toByte(), 0x31.toByte(),  //     Usage (Y)
    0x09.toByte(), 0x38.toByte(),  //     Usage (Wheel)
    0x15.toByte(), 0x81.toByte(),  //     Logical Minimum (-127)
    0x25.toByte(), 0x7F.toByte(),  //     Logical Maximum (127)
    0x75.toByte(), 0x08.toByte(),  //     Report Size (8)
    0x95.toByte(), 0x03.toByte(),  //     Report Count (3)
    0x81.toByte(), 0x06.toByte(),  //     Input (Data,Var,Rel)
    0xC0.toByte(),  //   End Collection
    0xC0.toByte(), // End Collection

    // Consumer control (Media)
    0x05.toByte(), 0x0C.toByte(),                  // USAGE_PAGE (Consumer Devices)
    0x09.toByte(), 0x01.toByte(),                  // USAGE (Consumer Control)
    0xA1.toByte(), 0x01.toByte(),                  // COLLECTION (Application)
    0x85.toByte(), REPORT_ID_MEDIA.toByte(),       //   REPORT_ID (3) - Use a unique ID
    0x15.toByte(), 0x00.toByte(),                  //   LOGICAL_MINIMUM (0)
    0x25.toByte(), 0x01.toByte(),                  //   LOGICAL_MAXIMUM (1)
    0x75.toByte(), 0x01.toByte(),                  //   REPORT_SIZE (1)
    0x95.toByte(), 0x08.toByte(),                  //   REPORT_COUNT (16) - 16 bits for 16 different keys
    0x09.toByte(), 0xB3.toByte(),                  //   USAGE (Fast Forward) -> Jump Forward
    0x09.toByte(), 0xB4.toByte(),                  //   USAGE (Rewind) -> Jump Backward
    0x09.toByte(), 0xB5.toByte(),                  //   USAGE (Scan Next Track)
    0x09.toByte(), 0xB6.toByte(),                  //   USAGE (Scan Previous Track)
    0x09.toByte(), 0xCD.toByte(),                  //   USAGE (Play/Pause)
    0x09.toByte(), 0xE2.toByte(),                  //   USAGE (Mute)
    0x09.toByte(), 0xE9.toByte(),                  //   USAGE (Volume Up)
    0x09.toByte(), 0xEA.toByte(),                  //   USAGE (Volume Down)
    0x81.toByte(), 0x02.toByte(),                  //   INPUT (Data,Var,Abs)
    0xC0.toByte(),                                 // END_COLLECTION

    // Battery report
//    0x05.toByte(), 0x0C.toByte(),                  // USAGE_PAGE (Consumer Devices)
//    0x09.toByte(), 0x01.toByte(),                  // USAGE (Consumer Control)
//    0xA1.toByte(), 0x01.toByte(),                  // COLLECTION (Application)
//    0x85.toByte(), 0x04.toByte(),                  //   REPORT_ID (4)
//    0x05.toByte(), 0x06.toByte(),                  //   USAGE_PAGE (Generic Device Controls) <-- FIXED (0x06)
//    0x09.toByte(), 0x20.toByte(),                  //   USAGE (Battery Strength)             <-- FIXED (0x20)
//    0x15.toByte(), 0x00.toByte(),                  //   LOGICAL_MINIMUM (0)
//    0x25.toByte(), 0x64.toByte(),                  //   LOGICAL_MAXIMUM (100)
//    0x75.toByte(), 0x08.toByte(),                  //   REPORT_SIZE (8)
//    0x95.toByte(), 0x01.toByte(),                  //   REPORT_COUNT (1)
//    0x81.toByte(), 0x02.toByte(),                  //   INPUT (Data,Var,Abs)
//    0xC0.toByte(),                                  // END_COLLECTION

    // GamePad
        USAGE_PAGE(1),          0x01.toByte(), // USAGE_PAGE (Generic Desktop)
        USAGE(1),               0x05.toByte(), // USAGE (Gamepad)
        COLLECTION(1),          0x01.toByte(), // COLLECTION (Application)
        USAGE(1),               0x01.toByte(), //   USAGE (Pointer)
        COLLECTION(1),          0x00.toByte(), //   COLLECTION (Physical)

        // ------------------------------------------------- Buttons (1 to 64)
        USAGE_PAGE(1),          0x09.toByte(), //     USAGE_PAGE (Button)
        USAGE_MINIMUM(1),       0x01.toByte(), //     USAGE_MINIMUM (Button 1)
        USAGE_MAXIMUM(1),       0x40.toByte(), //     USAGE_MAXIMUM (Button 64)
        LOGICAL_MINIMUM(1),     0x00.toByte(), //     LOGICAL_MINIMUM (0)
        LOGICAL_MAXIMUM(1),     0x01.toByte(), //     LOGICAL_MAXIMUM (1)
        REPORT_SIZE(1),         0x01.toByte(), //     REPORT_SIZE (1)
        REPORT_COUNT(1),        0x40.toByte(), //     REPORT_COUNT (64)
        INPUT(1),            0x02.toByte(), //     INPUT (Data, Variable, Absolute) ;64 button bits
        // ------------------------------------------------- X/Y position, Z/rZ position
        USAGE_PAGE(1), 	        0x01.toByte(), //		USAGE_PAGE (Generic Desktop)
        COLLECTION(1), 	        0x00.toByte(), //		COLLECTION (Physical)
        USAGE(1), 		        0x30.toByte(), //     USAGE (X)
        USAGE(1), 		        0x31.toByte(), //     USAGE (Y)
        USAGE(1), 		        0x32.toByte(), //     USAGE (Z)
        USAGE(1), 		        0x35.toByte(), //     USAGE (rZ)
        0x16.toByte(), 			0x01.toByte(), 0x80.toByte(),//LOGICAL_MINIMUM (-32767)
        0x26.toByte(), 			0xFF.toByte(), 0x7F.toByte(),//LOGICAL_MAXIMUM (32767)
        REPORT_SIZE(1),         0x10.toByte(), //		REPORT_SIZE (16)
        REPORT_COUNT(1), 	    0x04.toByte(), //		REPORT_COUNT (4)
        INPUT(1), 		    0x02.toByte(), //     INPUT (Data,Var,Abs)
        // ------------------------------------------------- Triggers
        USAGE(1),               0x33.toByte(), //     USAGE (rX) Left Trigger
        USAGE(1),               0x34.toByte(), //     USAGE (rY) Right Trigger
        0x15.toByte(),          0x00.toByte(),                // 	Logical Minimum (0)
        0x27.toByte(),          0xFF.toByte(), 0xFF.toByte(), 0.toByte(), 0.toByte(),    // 	Logical Maximum (65535)
        REPORT_SIZE(1),         0x10.toByte(), //     REPORT_SIZE (16)
        REPORT_COUNT(1),        0x02.toByte(), //     REPORT_COUNT (2)
        INPUT(1),            0x02.toByte(), //     INPUT (Data, Variable, Absolute) ;4 bytes (X,Y,Z,rZ)
        // ------------------------------------------------- Sliders
        USAGE(1),               0x36.toByte(), //     USAGE (Slider) Slider 1
        USAGE(1),               0x36.toByte(), //     USAGE (Slider) Slider 2
        0x15.toByte(),          0x00.toByte(),                // 	Logical Minimum (0)
        0x27.toByte(),          0xFF.toByte(), 0xFF.toByte(), 0.toByte(), 0.toByte(),    // 	Logical Maximum (65535)
        REPORT_SIZE(1),         0x10.toByte(), //     REPORT_SIZE (16)
        REPORT_COUNT(1),        0x02.toByte(), //     REPORT_COUNT (2)
        INPUT(1),            0x02.toByte(), //     INPUT (Data, Variable, Absolute) ;20 bytes (slider 1 and slider 2)
        END_COLLECTION(0),		 //     END_COLLECTION
        // ------------------------------------------------- Hats
        USAGE_PAGE(1),          0x01.toByte(), //     USAGE_PAGE (Generic Desktop)
        USAGE(1),               0x39.toByte(),			 //     Usage (Hat Switch) Hat 4
        USAGE(1),               0x39.toByte(),			 //     Usage (Hat Switch) Hat 3
        USAGE(1),               0x39.toByte(),			 //     Usage (Hat Switch) Hat 2
        USAGE(1),               0x39.toByte(),			 //     Usage (Hat Switch) Hat 1
        0x15.toByte(),          0x01.toByte(), 				 //	    Logical Min (1)
        0x25.toByte(),          0x08.toByte(),				 //	    Logical Max (8)
        0x35.toByte(),          0x00.toByte(),				 //     Physical Min (0)
        0x46.toByte(),          0x3B.toByte(), 0x01.toByte(),			 //     Physical Max (315)
        0x65.toByte(),          0x12.toByte(),				 //     Unit (SI Rot : Ang Pos)
        0x75.toByte(),          0x08.toByte(), 				 //	    Report Size (8)
        0x95.toByte(),          0x04.toByte(), 				 //	    Report Count (4)
        0x81.toByte(),          0x42.toByte(), 				 //	    Input (Data, Variable, Absolute)

        END_COLLECTION(0),         //     END_COLLECTION
        END_COLLECTION(0)          //     END_COLLECTION
)
