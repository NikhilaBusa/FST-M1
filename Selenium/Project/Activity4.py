from selenium import webdriver
from selenium.webdriver.common.by import By
import pytest

def testactivity4():
    driver = webdriver.Firefox()
    driver.get("https://alchemy.hguy.co/lms")
    firstInfoEle = driver.find_elements(By.XPATH, "//div[@class='caption']/h3")
    print("Title of 2nd course: ", firstInfoEle[1].text)
    assert firstInfoEle[1].text == "Email Marketing Strategies"
    driver.quit()

