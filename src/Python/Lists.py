if __name__ == '__main__':
    N = int(input())
    answer_list = []
    for _ in range(N):
        command = input().split()
        if command[0] == "insert":
            answer_list.insert(int(command[1]),int(command[2]))
        elif command[0] == "append":
            answer_list.append(int(command[1]))
        elif command[0] == "remove":
            answer_list.remove(int(command[1]))
        elif command[0] == "sort":
            answer_list.sort()
        elif command[0] == "pop":
            answer_list.pop()
        elif command[0] == "reverse":
            answer_list.reverse()
        else:
            print(answer_list)
