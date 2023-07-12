import time

from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

from selenium.webdriver.common.by import By

serv = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=serv) as driver:
    driver.get("https://training-support.net/selenium/dynamic-controls")
    print(driver.title)
    wait = WebDriverWait(driver, 10)
    checkbox = driver.find_element(By.ID, "dynamicCheckbox")
    checkbox_toggle = driver.find_element(By.ID, "toggleCheckbox")

    checkbox_toggle.click()
    print("Checkbox hidden")
    wait.until(expected_conditions.invisibility_of_element(checkbox))
    checkbox_toggle.click()
    print("Checkbox visible")
    checkbox.click()
    print("Checkbox selected")
    driver.quit()
