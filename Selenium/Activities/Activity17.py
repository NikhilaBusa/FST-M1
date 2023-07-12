from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService

serv = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=serv) as driver:
    driver.get("https://training-support.net/selenium/selects")
    print("Title is: ", driver.title)
    select = Select(driver.find_element(By.ID, "single-select"))
    select.select_by_visible_text("Option 2")
    select.select_by_index(3)
    select.select_by_value("4")
    print("Options are:", "\n")
    for item in select.options:
        print(item.text)
    driver.quit()
