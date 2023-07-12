from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService

serv = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=serv) as driver:
    driver.get("https://www.training-support.net/selenium/input-events")
    print("Title of page: ", driver.title)
    action = ActionChains(driver)
    action.click().pause(2).perform()
    print("Side active on left click: ", driver.find_element(By.XPATH, "//div[@class='active']").text)
    action.double_click().pause(2).perform()
    print("Side active on double click: ", driver.find_element(By.XPATH, "//div[@class='active']").text)
    action.context_click().pause(2).perform()
    print("Side active on right click: ", driver.find_element(By.XPATH, "//div[@class='active']").text)
    driver.quit()
