from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService

serv = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=serv) as driver:
    wait = WebDriverWait(driver, 10)
    driver.get("https://training-support.net/selenium/dynamic-controls")
    print("Title is: ", driver.title)
    checkboxEle = driver.find_element(By.XPATH, "//input[@class='willDisappear']")
    print("Is checkbox visible? ", checkboxEle.is_displayed())
    driver.find_element(By.ID, "toggleCheckbox").click()
    wait.until(expected_conditions.invisibility_of_element(checkboxEle))
    print("Is checkbox visible after clicking button? ", checkboxEle.is_displayed())
    driver.quit()
