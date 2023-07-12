
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

from selenium.webdriver.common.by import By

serv = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service = serv) as driver:
    driver.get("https://www.training-support.net/")
    print("Title of page: ", driver.title)
    driver.find_element(By.ID,"about-link").click()
    print("Title of page: ", driver.title)
    driver.quit()