
<a href="https://tryhackme.com/room/caseb4dm755" target="_blank"><img src="./banner.png" width="700px" /></a>

## Background

This is a room that concerns itself with a hypothetical forensic investigation involving intellectual property theft. In this room, I play the role of a "first responder" where I image a flash drive and conduct a brief analysis of its contents. 

### Writeup

* "Aleksey" (2024). _TryHackMe writeup: Digital Forensics Case B4DM755_. InfoSec Write-ups. https://infosecwriteups.com/tryhackme-writeup-digital-forensics-case-b4dm755-e196e00eae9a

## Takeaways

~~I won't do a writeup of this room~~ Nope, I did a writeup. Here are some things that I found noteworthy while doing this room:

* Do not always be fooled by the filename extension of the file being analysed. The person using the external storage medium may have changed it to baffle investigators.
* When working on a professional digital forensics case, always follow a strict procedure for the preservation of data: things like the chain-of-custody and file hashing must be made use of to ensure the integrity of the investigation.
    * Dump physmem and random access memory (RAM) first.
    * In the preservation of data, do a cold shutdown of the computer as to not trigger anti-forensic measures that the computer operator may have put into place.
    * Image the hard drive/other external, non-volatile storage medium after a cold shutdown.
    * When imaging the hard drive or other non-volatile storage mediums, be sure to use a write-blocker to prevent unintentionally writing data onto the hard drive.

