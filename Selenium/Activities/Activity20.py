from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService

serv = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=serv) as driver:
    driver.get("https://training-support.net/selenium/javascript-alerts")
    wait = WebDriverWait(driver, 10)
    driver.find_element(By.ID, "prompt").click()
    wait.until(expected_conditions.alert_is_present())
    prompt_alert = driver.switch_to.alert
    print("Text: ", prompt_alert.text)
    prompt_alert.send_keys("Awesome!")
    prompt_alert.accept()
    driver.quit()
    
