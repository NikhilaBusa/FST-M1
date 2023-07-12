from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService

serv = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=serv) as driver:
    wait = WebDriverWait(driver, 10)
    driver.get("https://www.training-support.net/selenium/dynamic-attributes")
    print("Page title is: ", driver.title)
    username = driver.find_element(By.XPATH, "//input[contains(@class, '-username')]")
    password = driver.find_element(By.XPATH, "//input[contains(@class, '-password')]")
    confirm_password = driver.find_element(By.XPATH, "//label[contains(text(), 'Confirm Password')]//following::input")
    email = driver.find_element(By.XPATH, "//input[contains(@class, 'email-')]")

    username.send_keys("admin")
    password.send_keys("password")
    confirm_password.send_keys("password")
    email.send_keys("adm.in@sample.com")
    driver.find_element(By.XPATH, "//button[text()='Sign Up']").click()
    wait.until(expected_conditions.visibility_of_element_located((By.ID, "action-confirmation")))
    message = driver.find_element(By.ID, "action-confirmation").text
    print("Success message: ", message)