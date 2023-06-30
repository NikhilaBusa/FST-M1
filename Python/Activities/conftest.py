import pytest

@pytest.fixture()
def input_list():
    listofnum = []
    for i in range(1,11):
        listofnum.append(i)
    return listofnum

@pytest.fixture()
def wallet():
    amount = 0
    return amount