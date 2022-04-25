if __name__ == '__main__':
    students = []
    for _ in range(int(input())):
        name = input()
        score = float(input())
        students.append([name,score])
        
    second_lowest_grade = sorted({ x[1] for x in students})[1]
    
    print("\n".join(student[0] for student in sorted(students) if student[1] == second_lowest_grade))
