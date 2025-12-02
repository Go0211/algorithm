s = input().split()

for i in range(len(s)):
    s[i] = int(s[i])

# 조건문
a = s[0]
b = s[1]
c = s[2]

if a > b:
    if b > c:
        print(c , b , a)
    else:
        if c > a:
            print(b, a, c)
        else:
            print(b, c, a)
else:
    if a > c:
        print(c, a, b)
    else:
        if b > c:
            print(a, c, b)
        else:
            print(a, b, c)