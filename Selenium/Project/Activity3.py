from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Firefox()
driver.get("https://alchemy.hguy.co/lms")
first_info_box = driver.find_element(By.XPATH, "//h3[text()=' Actionable Training ']")
assert first_info_box.text == "Actionable Training"
driver.quit()