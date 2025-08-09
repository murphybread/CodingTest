def solution(numbers):
    str_numbers = list(map(str, numbers))
    
    # 핵심: 비교를 위한 충분히 긴 문자열 만들기
    str_numbers.sort(key=lambda x: x*3, reverse=True)
    
    result = ''.join(str_numbers)
    return '0' if result[0] == '0' else result