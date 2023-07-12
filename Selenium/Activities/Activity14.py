from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService

serv = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=serv) as driver:
    driver.get("https://www.training-support.net/selenium/tables")
    print("Page title is: ", driver.title)
    columns = driver.find_elements(By.XPATH, "//table[@id='sortableTable']/thead/tr/th")
    print("Number of columns: ", len(columns))
    rows = driver.find_elements(By.XPATH, "//table[@id='sortableTable']/tbody/tr")
    print("Number of rows: ", len(rows))

    print("Cell value at second row and second column: ", driver.find_element(By.XPATH, "//table[@id='sortableTable']/tbody/tr[2]/td[2]").text)

    driver.find_element(By.XPATH, "//table[@id='sortableTable']/thead/tr/th[1]").click()
    print("Cell value at second row and second column: ", driver.find_element(By.XPATH, "//table[@id='sortableTable']/tbody/tr[2]/td[2]").text)
    driver.quit()