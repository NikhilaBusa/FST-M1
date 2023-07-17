from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

serv = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=serv) as driver:
    wait = WebDriverWait(driver, 10)
    driver.get("https://alchemy.hguy.co/lms")
    print("Page title is: ", driver.title)
    assert driver.title == "Alchemy LMS – An LMS Application"