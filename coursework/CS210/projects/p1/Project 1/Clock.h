#ifndef ADD_H_INCLUDED
#define ADD_H_INCLUDED
#include <string>

extern unsigned int clockSecond;
extern unsigned int clockMinute;
extern unsigned int clockHour;

void setTime(unsigned int, unsigned int, unsigned int);
void addHour();
void addSecond();
void addMinute();

unsigned int getSecond();
unsigned int getMinute();
unsigned int getHour();
std::string get24HourFormat(unsigned int, unsigned int, unsigned int);
std::string get12HourFormat(unsigned int, unsigned int, unsigned int);

std::string twoDigitString(unsigned int);
std::string nCharString(size_t, char);

#endif