from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.firefox.service import Service as FirefoxService

serv = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=serv) as driver:
    driver.get("https://training-support.net/selenium/target-practice")
    print("Title is: ", driver.title)
    print("Title of 3rd header", driver.find_element(By.XPATH, "//div/h3").text)
    print("Color of 5th header", driver.find_element(By.XPATH, "//div/h5").value_of_css_property("color"))
    print("Classes of violet button: ", driver.find_element(By.XPATH, "//button[text()='Violet']").get_attribute("class"))
    print("Text of grey button: ", driver.find_element(By.CLASS_NAME, "ui.grey").text)
    driver.quit()
    