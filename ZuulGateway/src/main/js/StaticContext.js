const StaticContext =
{
    baseUrlOld: "../partner",
    baseUrl:getBaseUrl(),
    LogedIn: false,
}

function getBaseUrl()
{
  return window.location.origin.toString();
}
export default StaticContext