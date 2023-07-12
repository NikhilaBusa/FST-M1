from selenium import webdriver
from selenium.webdriver import ActionChains, Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

serv = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=serv) as driver:
    driver.get("https://training-support.net/selenium/input-events")
    print("Title is: ", driver.title)
    action = ActionChains(driver)
    action.send_keys("N")
    action.key_down(Keys.CONTROL)
    action.send_keys("a")
    action.send_keys("c")
    action.key_up(Keys.CONTROL)
    action.perform()
    driver.quit()
