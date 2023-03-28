
# "Flag Finder" Script
# .. For Flare-on 2018, "Ultimate Minesweeper 1" Challenge

# By A. S. "Aleksey" Ahmann

class BaseFunctions:

    def __init__(self):
        pass

    def uint(n):
        # sauce: https://bytes.com/topic/python/answers/614797-unsigned-integer
        return n & 0xFFFFFFFF

class MainForm:

    def __init__(self):
        pass

    bf = BaseFunctions()

    VALLOC_NODE_LIMIT = bf.uint(30)
    VALLOC_TYPE_HEADER_PAGE = bf.uint(4294966400)
    VALLOC_TYPE_HEADER_POOL = bf.uint(4294966657)
    VALLOC_TYPE_HEADER_RESERVED = bf.uint(4294967026)
    
