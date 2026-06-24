# CodeSignal Company Challenges
#
# A solution to GoDaddy's "domainType" challenge
# By A. S. "Aleksey" Ahmann, hackermaneia@riseup.net
#

def domainType(domains):
    tld_map = {
        "org":"organization",
        "com":"commercial",
        "net":"network",
        "info":"information"
    }
    
    return [tld_map[domain.split(".")[len(domain.split(".")) - 1]] for domain in domains]
