# 가장 많이 받은 선물 2024 KAKAO WINTER INTERNSHIP

def solution(friends, gifts):
    gifted = {friend: {} for friend in friends}
    gift_idx = {friend: 0 for friend in friends}

    for gift in gifts:
        giver, receiver = gift.split() 
        gifted[giver][receiver] = gifted[giver].get(receiver, 0) + 1
        gift_idx[giver] += 1
        gift_idx[receiver] -= 1
    will_get = [0] * len(friends)
    
    for i in range(len(friends)):
        curr = friends[i]
        for j in range(i + 1, len(friends)):
            another = friends[j]
            a = gifted[curr].get(another, 0) 
            b = gifted[another].get(curr, 0) 
            
            if a > b: 
                will_get[i] += 1
            elif a < b:  
                will_get[j] += 1
            else: 
                ai, bi = gift_idx[curr], gift_idx[another]
                if ai > bi:
                    will_get[i] += 1
                elif bi > ai:
                    will_get[j] += 1

    return max(will_get)
