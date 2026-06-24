
with open("dump.txt", "r") as domains_dump:
    data_exfiltrated = ""
    for domain in domains_dump.readlines():
        data_exfiltrated += domain[0]
    print(data_exfiltrated)

