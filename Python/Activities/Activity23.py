import pytest

def testsumlist(input_list):
    sum = 0
    for i in input_list:
        sum += int(i)
    assert sum == 55