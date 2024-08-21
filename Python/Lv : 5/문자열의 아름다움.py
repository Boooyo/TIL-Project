# 월간 코드 챌린지 시즌1 문자열의 아름다움

from collections import defaultdict
from itertools import groupby

def solution(s):
    lumps = defaultdict(lambda: defaultdict(int))

    for char, group in groupby(s):
        lumps[char][len(list(group))] += 1

    n = len(s)
    unpretty = (n - 1) * n * (n + 1) // 6

    for lump in lumps.values():
        total = sum(l * count for l, count in lump.items())  
        both_side = sum(lump.values())  
       
        for i in range(1, max(lump) + 1):
            unpretty -= total * (total - 1) // 2  
            total -= both_side 
            both_side -= lump[i]  
    
    return unpretty
