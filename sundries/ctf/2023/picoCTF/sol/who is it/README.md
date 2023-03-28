# who is it

Author: Junias Bonou
Location: https://play.picoctf.org/events/72/challenges/challenge/388
Tags: Forensics, email

## Problem

> Someone just sent you an email claiming to be Google's co-founder Larry Page but you suspect a scam. Can you help us identify whose mail server the email actually originated from? Download the email file [here](https://artifacts.picoctf.net/c/499/email-export.eml). ``Flag: picoCTF{FirstnameLastname}``.

The problem comes with a hint stating that "whois can be helpful on IP addresses also, not only domain names." It also came with an email file called ``email-export.eml`` ([download it here](https://artifacts.picoctf.net/c/499/email-export.eml)).

## Solution

I proceeded to download the ``.eml`` artifact and inspect it with my text editor. The following is a relevant snippet of the email's source:

```
        by mx.google.com with ESMTPS id f16-20020a05600c4e9000b003a1947873d6si1882702wmq.224.2022.07.07.23.19.47
        for <francismanzi@gmail.com>
        (version=TLS1_3 cipher=TLS_AES_256_GCM_SHA384 bits=256/256);
        Thu, 07 Jul 2022 23:19:47 -0700 (PDT)
Received-SPF: pass (google.com: domain of lpage@onionmail.org designates 173.249.33.206 as permitted sender) client-ip=173.249.33.206;
Authentication-Results: mx.google.com;
       dkim=pass header.i=@onionmail.org header.s=jan2022 header.b=4sU2nk5Z;
       spf=pass (google.com: domain of lpage@onionmail.org designates 173.249.33.206 as permitted sender) smtp.mailfrom=lpage@onionmail.org;
```

I noticed a ``client-ip`` of ``173.249.33.206`` and proceeded to do a ``whois`` lookup against said IP address:

```
dna@deniers:~/who is it$ whois 173.249.33.206

#
# ARIN WHOIS data and services are subject to the Terms of Use
# available at: https://www.arin.net/resources/registry/whois/tou/
#
# If you see inaccuracies in the results, please report at
# https://www.arin.net/resources/registry/whois/inaccuracy_reporting/
#
# Copyright 1997-2023, American Registry for Internet Numbers, Ltd.
#

[... snip ...]

person:         Wilhelm Zwalina
address:        Contabo GmbH
address:        Aschauer Str. 32a
address:        81549 Muenchen
phone:          +49 89 21268372
fax-no:         +49 89 21665862
nic-hdl:        MH7476-RIPE
mnt-by:         MNT-CONTABO
mnt-by:         MNT-GIGA-HOSTING
created:        2010-01-04T10:41:37Z
last-modified:  2020-04-24T16:09:30Z
source:         RIPE

% Information related to '173.249.32.0/23AS51167'

route:          173.249.32.0/23
descr:          CONTABO
origin:         AS51167
mnt-by:         MNT-CONTABO
created:        2018-02-01T09:50:10Z
last-modified:  2018-02-01T09:50:10Z
source:         RIPE

% This query was served by the RIPE Database Query Service version 1.106 (SHETLAND)


dna@deniers:~/who is it$ 
```

Burried in the results was an attribute ``person`` with the value ``Wilhelm Zwalina``. From this information, I worked out that the flag is: ``picoCTF{WilhelmZwalina}``.

## References
