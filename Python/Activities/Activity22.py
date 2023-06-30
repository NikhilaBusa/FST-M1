import pytest
import math


def testsum():
    no1 = 30
    no2 = 40
    sum = no1 + no2
    assert sum == 70


def testdiff():
    no1 = 30
    no2 = 10
    diff = no1 - no2
    assert diff == 20


@pytest.mark.activity
def testprodlast():
    no1 = 10
    no2 = 20
    mul = no1 * no2
    assert mul == 200


@pytest.mark.activity
def testquotlast():
    no1 = 23
    no2 = 5
    quot = no1 / no2
    assert quot == 4.6
