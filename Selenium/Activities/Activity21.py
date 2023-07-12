import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService

serv = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=serv) as driver:
    driver.get("https://www.training-support.net/selenium/tab-opener")
    main_window = driver.current_window_handle
    print("Current handle", main_window)
    wait = WebDriverWait(driver, 10)
    driver.find_element(By.ID, "launcher").click()
    wait.until(expected_conditions.number_of_windows_to_be(2))
    print("All window handles: ", driver.window_handles)
    driver.switch_to.window(driver.window_handles[1])
    print("Title of new tab: ", driver.title)
    time.sleep(5)
    heading = driver.find_element(By.XPATH, "//div[@class='content']")
    wait.until(expected_conditions.visibility_of(heading))
    print("Content:", heading.text)
    driver.find_element(By.ID, "actionButton").click()
    wait.until(expected_conditions.number_of_windows_to_be(3))
    driver.switch_to.window(driver.window_handles[2])
    time.sleep(5)
    print("Title of new tab: ", driver.title)
    print("Content:", driver.find_element(By.CLASS_NAME, "content").text)
    driver.quit()


