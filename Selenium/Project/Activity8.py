import time

from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Firefox()
driver.get("https://alchemy.hguy.co/lms")
driver.find_element(By.XPATH, "//a[contains(text(),'Contact')]").click()
driver.find_element(By.XPATH,"//form/div/div/label[contains(text(),'Full Name')]/following-sibling::input").send_keys("Someone")
driver.find_element(By.XPATH,"//form/div/div/label[contains(text(),'Email')]/following-sibling::input").send_keys("some@s.com")
driver.find_element(By.XPATH,"//form/div/div/label[contains(text(),'Subject')]/following-sibling::input").send_keys("Subject")
driver.find_element(By.XPATH, "//form/div/div/label[contains(text(),'Comment or Message ')]/following-sibling::textarea").send_keys("Feedback")
driver.find_element(By.XPATH, "//button[@type='submit']").click()

confirmation_message = driver.find_element(By.XPATH, "//div[@id='wpforms-confirmation-8']/p").text
print(confirmation_message)

driver.quit()