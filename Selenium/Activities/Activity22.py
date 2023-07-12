import time

from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService

serv = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=serv) as driver:
    driver.get("https://www.training-support.net/selenium/popups")
    print("Title is: ", driver.title)
    action = ActionChains(driver)
    sign_in = driver.find_element(By.XPATH, "//button[contains(text(), 'Sign In')]")
    action.move_to_element(sign_in).perform()
    print("On hover message: ", sign_in.get_attribute("data-tooltip"))
    sign_in.click()
    username = driver.find_element(By.ID, "username")
    password = driver.find_element(By.ID, "password")
    username.send_keys("admin")
    password.send_keys("password")
    driver.find_element(By.XPATH, "/html/body/div[4]/div/div[2]/div/div/button").click()
    print("Confirmation message: ", driver.find_element(By.ID, "action-confirmation").text)
    driver.quit()
