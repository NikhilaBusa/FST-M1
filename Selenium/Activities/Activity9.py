from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService

serv = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=serv) as driver:
    driver.get("https://training-support.net/selenium/ajax")
    print("Title is: ", driver.title)
    wait = WebDriverWait(driver, 10)
    driver.find_element(By.XPATH, "//button[text()='Change Content']").click()
    wait.until(expected_conditions.text_to_be_present_in_element((By.XPATH, "//div/h1"), "HELLO!"))
    print("Text in h1 tag: ", driver.find_element(By.XPATH, "//div/h1").text)
    wait.until(expected_conditions.text_to_be_present_in_element((By.XPATH, "//div/h3"), "I'm late!"))
    print("Text in h3 tag: ", driver.find_element(By.XPATH, "//div/h3").text)
    driver.quit()
