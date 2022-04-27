from msedge.selenium_tools import Edge, EdgeOptions

options = EdgeOptions()
options.use_chromium = True
options.add_argument("--lang=fr");
options.add_experimental_option('excludeSwitches', ['enable-logging'])
prefs = {
    "translate_whitelists": {'pt':'en'},
    "translate":{"enabled":"true"}}
options.add_experimental_option("prefs", prefs)

driver = Edge(executable_path=r"C:\Users\Administrator\Desktop\msedgedriver.exe", options=options)
driver.get("https://www.gov.br/economia/pt-br/acesso-a-informacao/institucional/quem-e-quem/gabinete/quem-e-quem-do-gabinete-do-ministro")
