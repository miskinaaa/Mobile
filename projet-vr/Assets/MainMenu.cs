using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class MainMenu : MonoBehaviour
{
    public void measure()
    {
        SceneManager.LoadScene(1);
    }

    public void chicken()
    {
        SceneManager.LoadScene(2);
    }

    public void poster()
    {
        SceneManager.LoadScene(3);
    }

    public void exitGame()
    {
        Application.Quit();
    }
}