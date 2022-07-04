def swap_case(s):
    arr = list(s)
    temp = ""
    for ss in arr :
        if ss.islower() :
           temp += ss.upper()
        else :
           temp += ss.lower()
         

    return temp

if __name__ == '__main__':
    s = raw_input()
    result = swap_case(s)
    print result
