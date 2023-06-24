# money-ware

* Author: Juni19
* Location: https://play.picoctf.org/practice/challenge/357
* Tags: General Skills, osint

## Problem

> Flag format: picoCTF{Malwarename} The first letter of the malware name should be capitalized and the rest lowercase. Your friend just got hacked and has been asked to pay some bitcoins to 1Mz7153HMuxXTuR2R1t78mGSdzaAtNbBWX. He doesn't seem to understand what is going on and asks you for advice. Can you identify what malware he's being a victim of?

This problem also comes with two hints: the first one states that "[s]ome crypto-currencies abuse databases exist; check them out!" and the second one states that "[m]aybe Google might help."

## Solution

I figured that I could look start by looking up a utility or web application that takes note of Bitcoin transactions. I found one called _Bitchair_ [Ref 1, Figure 1] and queried the given Bitcoin address, which returned a transaction [Ref 2, Figure 2]. I also tried to query the given Bitcoin address on VirusTotal [Ref 3], but was given an error message [Ref 4, Figure 3].

I decided to examine the Blockchair transactions a little more, and found an interesting transaction hash (Figure 4). I looked up the transaction hash on a search engine (Figure 5), and found out that it may be related to the Peyta ransomware. I then constructed the flag ``picoCTF{petya}``, submitted it and it turned out to be the correct flag. This Bitcoin address is most likely related to the Petya Ransomware.

## References

1. https://blockchair.com/bitcoin
2. https://blockchair.com/bitcoin/address/1Mz7153HMuxXTuR2R1t78mGSdzaAtNbBWX
3. https://www.virustotal.com/gui/home/search
4. https://www.virustotal.com/gui/search/1Mz7153HMuxXTuR2R1t78mGSdzaAtNbBWX
