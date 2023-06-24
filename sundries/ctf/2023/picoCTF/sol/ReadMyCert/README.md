# ReadMyCert

* Author: Sunday Jacob Nwanyim
* Location: https://play.picoctf.org/practice/challenge/367
* Tags: Cryptography

## Problem

> How about we take you on an adventure on exploring certificate signing requests Take a look at this CSR file [here](https://artifacts.picoctf.net/c/424/readmycert.csr).

This challenge came with a hint that states "[d]ownload the certificate signing request and try to read it" and a file called ``readmycert.csr`` ([download it here](./readmycert.csr)).

## Solution

I downloaded the ``.csr`` file and looked up how to read them. I came across an article discussing how to do so [1], and followed their instructions:

```
dna@deniers:~/ReadMyCert$ openssl req -in readmycert.csr -noout -text
Certificate Request:
    Data:
        Version: 1 (0x0)
        Subject: CN = picoCTF{read_mycert_5aeb0d4f}, name = ctfPlayer
        Subject Public Key Info:
            Public Key Algorithm: rsaEncryption
                RSA Public-Key: (2048 bit)
                Modulus:
                    00:c0:a4:7f:5d:6b:99:5f:2b:82:a3:ef:0b:66:62:
                    3c:0e:96:fb:94:5f:39:3c:14:ea:ed:d6:a4:6b:cb:
                    03:ed:98:17:3a:1c:04:fb:ad:68:04:d3:c5:33:c1:
                    fa:e6:8d:d9:93:77:67:92:76:09:31:46:98:fc:c8:
                    e2:c5:10:7d:2a:a1:64:6b:80:a9:b7:cc:c8:30:d1:
                    f2:94:6c:c2:62:18:54:9e:ac:d0:0a:5c:4e:88:bb:
                    1f:c9:b7:21:28:52:6d:e1:34:a5:95:12:20:9a:5b:
                    2b:56:bb:57:a9:49:aa:0c:05:30:32:35:aa:b8:0d:
                    84:68:19:68:c0:3f:97:e7:76:27:4b:c2:dc:46:1d:
                    02:28:f0:4a:cf:00:3d:ca:7a:c2:85:9b:14:66:30:
                    77:0e:4a:68:1b:23:9f:6d:e8:57:3d:86:e2:1d:ff:
                    4e:67:41:e6:0e:5e:e8:ea:be:92:08:b7:f0:d1:29:
                    44:34:b4:ca:55:e8:f6:65:24:a3:71:6a:4b:82:3a:
                    cb:d8:0e:b4:31:08:e2:e6:5a:08:96:6e:5c:70:e6:
                    06:9a:99:d3:83:1f:5d:b2:15:94:78:c5:f4:d3:0e:
                    8c:3b:d7:2e:89:cd:eb:9d:28:68:03:41:9b:86:e1:
                    06:58:22:77:41:71:e3:c6:77:ea:d6:ed:01:58:af:
                    64:47
                Exponent: 65537 (0x10001)
        Attributes:
        Requested Extensions:
            X509v3 Extended Key Usage: 
                TLS Web Client Authentication
    Signature Algorithm: sha256WithRSAEncryption
         76:71:ea:1f:6b:1b:f4:84:ed:10:a8:5f:a9:dd:93:90:4e:26:
         9a:d1:88:7a:71:3a:a3:cb:01:67:03:c8:a1:df:4a:d9:67:d3:
         f1:dc:41:9c:c8:ad:15:51:b2:6a:07:88:e9:9c:87:e9:9d:3c:
         10:35:6f:e3:39:6a:3f:b7:05:6b:4f:47:d8:ce:63:8b:e1:b7:
         e6:66:1c:02:9a:d1:67:d0:c7:06:f6:74:1c:6c:44:f2:93:4c:
         37:9a:d3:03:76:bb:c0:47:2e:54:8c:3d:b5:8f:36:ec:fe:4c:
         ac:92:2f:8d:71:7f:01:6e:33:85:4d:ff:2c:27:e7:c1:93:bd:
         d6:fb:1d:78:30:35:90:86:82:8d:8d:d5:68:51:ab:f7:41:32:
         26:a0:5c:c6:a1:c9:be:a0:5f:87:ab:ba:00:ae:eb:54:f9:b7:
         20:fc:d2:18:2c:34:18:da:ab:22:1d:cb:fc:21:45:f0:bf:3e:
         69:f7:40:79:9d:92:a0:79:64:23:de:cf:06:f6:38:b9:b8:e5:
         10:c6:bf:75:8e:07:9a:b4:06:87:e8:50:68:55:ab:be:7b:40:
         4f:2a:84:bd:e8:4e:f5:76:5a:52:e8:8b:76:16:69:99:09:30:
         27:91:de:f9:c7:f7:67:0a:0b:53:af:17:17:50:b8:b3:87:f0:
         63:2f:97:b5
dna@deniers:~/ReadMyCert$ 
```

The flag has been easily worked out to ``picoCTF{read_mycert_5aeb0d4f}``.

## References

1. https://www.sslshopper.com/csr-decoder.html

