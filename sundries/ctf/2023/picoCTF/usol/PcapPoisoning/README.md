# PcapPoisoning

Author: Mubarak Mikail
Location: https://play.picoctf.org/events/72/challenges/challenge/362
Tags: Forensics, pcap

## Problem

> How about some hide and seek heh? Download this [file](https://artifacts.picoctf.net/c/374/trace.pcap) and find the flag.

This challenge comes with a flag called ``trace.pcap`` ([download it here](./trace.pcap)).

## Solution

I decided to open up the ``trace.pcap`` packet sniff in Wireshark and proceeded to analyse it (Figure 1). Wireshark reports that packer number 1 is malformed (see Figure 2), and this may show itself to be useful information later. Packet number 4 shows an initiation to an FTP server, and I prompted to follow its TCP stream (Figure 3). It simply reported the following string:

```
    username root    password toor624a8b6}
```

I also followed several ``FTP Data`` streams and got strings around the following type: ``gc2VjcmV0OiBwaWNvQ1RGe``. That string appears to be associated with the ``rlogin`` protocol. 

Based on the title of this challenge, I figured that there may be some kind of network poisoning attack to do with this pcap file. So, I decided to research the topic and came up with some articles discussing it [4][5]. I asked myself "is it a DNS cache poisoning attack or an ARP poisoning attack?" 

To answer this, I searched for both ARP and DNS protocols, and found no ARP packets but found a malformed DNS packet (packet number 5, figure 4). The following contents of the packet, which stated that the "[f]lag is close," is rather sobering:

```
E7@|³55#.ÍiBwaWNvQ1RGe1Flag is close=
```

I then proceeded to follow the UDP stream of packet number 5 (Figure 5) and it just gave me the string given above.

## References

1. https://fareedfauzi.gitbook.io/ctf-checklist-for-beginner/
2. https://github.com/ZeroDayTea/CTF-Checklist
3. https://book.hacktricks.xyz/generic-methodologies-and-resources/basic-forensic-methodology/pcap-inspection
4. https://chrissanders.org/2008/04/using-arp-cache-poisoning-for-packet-analysis/
5. https://www.nic.cz/files/labs/DNS-cache-poisoning-attack-analysis.pdf
