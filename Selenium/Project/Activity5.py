from selenium import webdriver
from selenium.webdriver.common.by import By


driver = webdriver.Firefox()
driver.get("https://alchemy.hguy.co/lms")
driver.find_element(By.XPATH, "//a[contains(text(),'My Account')]").click()
assert driver.title == "My Account – Alchemy LMS"
driver.quit()
