# 모든 원소를 탐색하기에는 1백만은 부담됨
# 접두어의 경우 작은 길이의 번호가 큰 길이의 번호에 포함됨
# 중복은 없음

def solution(phone_book):
    phone_book.sort()  # 리스트를 먼저 정렬합니다.
    for i in range(len(phone_book) - 1):
        if phone_book[i+1].startswith(phone_book[i]):
            return False
    return True
