#include "pch.h"

#include "../Project 1/Clock.h"
#include "../Project 1/Clock.cpp"

TEST(TestBasicClock, TestBasicClock) {

	setTime(0, 0, 0);

	EXPECT_EQ(get12HourFormat(), "12:00:00 AM");
	EXPECT_EQ(get24HourFormat(), "00:00:00");

	addHour();
	EXPECT_EQ(get12HourFormat(), "1:00:00 AM");
	EXPECT_EQ(get24HourFormat(), "01:00:00");

	addMinute();
	EXPECT_EQ(get12HourFormat(), "1:01:00 AM");
	EXPECT_EQ(get24HourFormat(), "01:01:00");

	addSecond();
	EXPECT_EQ(get12HourFormat(), "1:01:01 AM");
	EXPECT_EQ(get24HourFormat(), "01:01:01");
}

TEST(TestAdvancedClock, TestAdvancedClock) {
	setTime(1, 58, 59);

	addSecond();
	EXPECT_EQ(get12HourFormat(), "1:59:00 AM");
	EXPECT_EQ(get24HourFormat(), "01:59:00");

	setTime(1, 59, 59);

	addMinute();
	EXPECT_EQ(get12HourFormat(), "2:00:59 AM");
	EXPECT_EQ(get24HourFormat(), "02:00:59");

	setTime(1, 59, 59);
	addSecond();
	EXPECT_EQ(get12HourFormat(), "2:00:00 AM");
	EXPECT_EQ(get24HourFormat(), "02:00:00");

	setTime(12, 0, 0);
	addSecond();
	EXPECT_EQ(get12HourFormat(), "12:00:01 PM");
	EXPECT_EQ(get24HourFormat(), "12:00:01");

	addMinute();
	EXPECT_EQ(get12HourFormat(), "12:01:01 PM");
	EXPECT_EQ(get24HourFormat(), "12:01:01");

	addHour();
	EXPECT_EQ(get12HourFormat(), "1:01:01 PM");
	EXPECT_EQ(get24HourFormat(), "13:01:01");

	setTime(11, 59, 59);
	addSecond();
	EXPECT_EQ(get12HourFormat(), "12:00:00 PM");
	EXPECT_EQ(get24HourFormat(), "12:00:00");

	setTime(23, 59, 59);
	addSecond();
	EXPECT_EQ(get12HourFormat(), "12:00:00 AM");
	EXPECT_EQ(get24HourFormat(), "00:00:00");
}
