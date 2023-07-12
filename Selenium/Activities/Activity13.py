from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService

serv = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=serv) as driver:
    driver.get("https://training-support.net/selenium/tables")
    print("Title is: ", driver.title)
    trEle = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr")
    print("No. of rows: ", len(trEle))
    tdEle = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[1]/td")
    print("No. of columns: ", len(tdEle), "\n")
    secondRowEle = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[3]")
    for item in secondRowEle:
        print(item.text, " ")
    print("\n", "2nd cell in 2nd row: ", driver.find_element(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]").text)
    driver.quit()