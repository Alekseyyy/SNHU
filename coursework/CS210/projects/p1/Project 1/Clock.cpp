#include "Clock.h"
using namespace std;

unsigned int clockHour;
unsigned int clockMinute;
unsigned int clockSecond;

/**
 * Sets the time for the clock
 * 
 * @param h, an unsigned integer for the hour
 * @param m, an unsigned integer for the minute
 * @param s, an unsigned integer for the second
 */
void setTime(unsigned int h, unsigned int m, unsigned int s) {

    clockHour = h;
    clockMinute = m;
    clockSecond = s;
}

/**
 * Adds one second
 */
void addSecond() {

    if (getSecond() >= 0 && getSecond() <= 58)
        setTime(getHour(), getMinute(), getSecond() + 1);
    else if (getSecond() == 59) {
        setTime(getHour(), getMinute(), 0);
        addMinute();
    }
}

/**
 * Adds one minute
 */
void addMinute() {
    if (getMinute() >= 0 && getMinute() <= 58)
        setTime(getHour(), getMinute() + 1, getSecond());
    else if (getMinute() == 59) {
        setTime(getHour(), 0, getSecond());
        addHour();
    }
    return;
}

/**
 * Adds one hour
 */
void addHour() {
    if (getHour() >= 0 && getHour() <= 22)
        setTime(getHour() + 1, getMinute(), getSecond());
    else if (getHour() == 23)
        setTime(0, getMinute(), getSecond());
    return;
}

/**
 * Gets the clock's current second
 * @return number of seconds in the clock
 */
unsigned int getSecond() {
    return clockSecond;
}

/**
 * Gets the clock's current minute
 * @return number of minute in the clock
 */
unsigned int getMinute() {
    return clockMinute;
}

/**
 * Gets the clock's current hour
 * @return number of hour in the clock
 */
unsigned int getHour() {
    return clockHour;
}

/**
 * Formats the time in military format
 *
 * @param h, hours 0 to 23
 * @param m, minutes 0 to 59
 * @param s, seconds 0 to 59
 *
 * @return hh:mm:ss
 */
string get24HourFormat(unsigned int h, unsigned int m, unsigned int s) {
    string strH = twoDigitString(h);
    string strM = twoDigitString(m);
    string strS = twoDigitString(s);

    return strH + ":" + strM + ":" + strS;
}

/**
 * Formats the time in am/pm format
 *
 * @param h, hours 0 to 23
 * @param m, minutes 0 to 59
 * @param s, seconds 0 to 59
 *
 * @return hh:mm:ss A M or hh:mm:ss P M where hh is between 01 and 12, inclusive
 */
string get12HourFormat(unsigned int h, unsigned int m, unsigned int s) {
    string strH = twoDigitString(h % 12);
    string strM = twoDigitString(m);
    string strS = twoDigitString(s);

    if (h == 0 || h == 12)
        strH = twoDigitString(12);

    if (h < 12)
        return strH + ":" + strM + ":" + strS + " AM";
    return strH + ":" + strM + ":" + strS + " PM";
}

/**
 * Formats a number as 2 digits, with a leading 0 if needed
 * This method can be useful when converting a time like 9 hours, 12 minutes and 3 seconds to "09:12:03"
 * It's a good building block to help you get that part right and not have to repeat code
 *
 * @param n number to format, assumed between 0 and 59, inclusive
 * @return two digit string representation of number
 */
string twoDigitString(unsigned int n) {
    /* Note that I referenced a StackOverflow
     * thread [1] for information on how to use
     * "to_string" to convert an unsigned integer
     * to a string. */

    string strN = to_string(n);
    if (n >= 0 && n <= 9)
        return "0" + strN;
    return strN;
}

/**
 * Returns a string of length n, each character a c.
 * For example, nCharString(5, '*') should return "*****"
 *
 * @param n string length, >=0
 * @return string of n c's
 */
string nCharString(size_t n, char c) {
    /**
     * Note that I reference a tutorial [2] for the specific
     * technique for appending a character to a string.
     */

    string returnString;
    for (int i = 0; i < n; i++)
        returnString += c;

    return returnString; // return the n character string
}
