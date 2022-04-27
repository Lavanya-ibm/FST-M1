import pytest
def test_addition():
    num1 = 10
    num2 = 20
    sum = num1 + num2

    assert sum == 30

def test_subtraction():

    num1 = 30
    num2 = 35

    diff = num1 - num2
    assert diff == -5
def test_multiplication():

    num1 = 5
    num2 = 20
    prod = num1 * num2
    assert prod == 100

def test_division():

    num1 = 20
    num2 = 5
    quot = num1 / num2
    assert quot == 4